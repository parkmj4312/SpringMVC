

import com.springmvc.springmvc.Star;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class HelloRequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.getName(), star.getAge());
    }

    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.getName(), star.getAge());
    }
}