package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.SampleForm;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	@GetMapping("/sample")
//	@ResponseBody
	public String sample(Model model) {
		String text ="Hello Spring Boot!!";
		model.addAttribute("message",text);
		return "index";
	}
	// http://localhost:8080/lesson/ にリクエストするとindex()が実行される
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    // http://localhost:8080/lesson/test にリクエストするとtest()が実行される
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Good Evening!";
    }
    @GetMapping("/request_test")
    // 返り値をレスポンスとして扱います
    @ResponseBody
    // name ... 名前、 bloodType ... 血液型
    // パラメータ名と仮引数名が同じな場合、@RequestParam String nameのようにパラメータ名の指定を省略できます
    public String getTest(@RequestParam(value = "name", required = false, defaultValue = "名無し") String name
                          , @RequestParam(value="bloodType",required=false,defaultValue="不明") String bloodType) {
        return "名前: " + name + "<br>血液型: " + bloodType;
    }
 // POST通信で/lesson/request_testにリクエストした場合にpostTestを実行します
    @PostMapping("/request_test")
    @ResponseBody
    public String postTest(SampleForm sampleForm) {
        return "名前: " + sampleForm.getName() + "<br>血液型: " + sampleForm.getBloodType();
    }
//    @GetMapping("/form_test")
//    public String formTest(SampleForm sampleForm, Model model) {
//        model.addAttribute("sampleForm", sampleForm);
//        return "lesson/form_test";
//    }
    @GetMapping("/form_test")
    // SampleFormをModel属性にセットするだけであればModelクラスは不要になります
    public String formTest(@ModelAttribute SampleForm sampleForm) {
        return "lesson/form_test";
    }
}

