package com.kgitbank.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgitbank.model.Human;
import com.kgitbank.model.Member;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/hello") //hello밑에 있는 모든것은 다 이쪽으로 보내주세요(서블릿에서 이녀석을보고 이쪽으로 찾아오는 것)
public class HelloController {
	
	@Autowired
	ServletContext application;
	
	//requestMapping을 여러단계로하는법
	@RequestMapping(value={"/minsu", "/민수"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String minsu() {
		log.info("minsu controller에 도착");
		
		return "/hello/minsu";
	}
	
	//옛날 파라미터 받는 방식
//	@GetMapping("/chulsu")
//	public void getChulsu(HttpServletRequest request) {
//		log.info("get chulsu controller에 도착");
//		log.info("name : " + request.getParameter("name"));
//	}
	//스프링 파라미터 받는방식(1)
//	@GetMapping("/chulsu")
//	public void getChulsu(String name, int age) {
//		log.info("get chulsu controller에 도착");
//		log.info("name : " + name);
//		log.info("age : " + age);
//	}
	//스프링 파라미터 받는방식(2)
	@GetMapping("/chulsu")
	public void getChulsu(Human human, @RequestParam("number") int myNumber, @RequestParam("taste") ArrayList<String> taste) {
		log.info("get chulsu controller에 도착");
		log.info("name : " + human.getName());
		log.info("age : " + human.getAge());
		log.info("myNumber : " + myNumber);
		log.info("taste : " + taste);
	}
	
	//체크박스처럼 여러개 들어올때는 ArrayList 로 받으면 된다
	//이 때, @RequestParam("")을 사용해야 한다
	
	
	@PostMapping("/chulsu")
	public void postChulsu() {
		log.info("post chulsu controller에 도착");
	}
	
	@GetMapping("/choosinsu")
	public String choo(Model model, @ModelAttribute("age") int age,@ModelAttribute("name") String name) {
		
		model.addAttribute("attr1", "ABC");
		model.addAttribute("ABCDEFG");
		
		//원래 이렇게 해야됨
//		model.addAttribute("age", age);
//		model.addAttribute("name", name);
		
		//그러나, @ModelAttribute를 이용하면
		//파라미터에 실려온 값이 매개변수에 꺼내져 있고, 모델에도 자동으로 실려있다.
		System.out.println("age : " + age);
		System.out.println("name : " + name);
		
		return "/hello/attrTest"; //prefix와 subfix가 앞뒤로 붙어져서 주소가 나오게됨
	}
	
	//전달 받은 값을 그대로 패스할 떄는 그냥 이렇게만 두면 끝
	//void로 두면 class에 매핑한 /hello 와 메서드에 매핑한 /park가 합쳐진 /hello/park 로 이동됨
	@GetMapping("/park")
	public void park(Human human) {}
	
	@GetMapping("/kim")
	public String kim() {
		//앞에 redirect:을 붙이면 뷰를 찾지 않고 리다이렉트를 응답한다
		//!!!! 어트리뷰트를 가지고 보내려면 redirect: 가 필요하다는 것
		return "redirect:/hello/park?name=kimC&age=32";
	}
	
	@RequestMapping("/model1")
	public ModelAndView modelAndView() {
	
		ModelAndView mnv = new ModelAndView();
		
		//addObject로 어트리뷰트 싣고
		mnv.addObject("a", 10);
		mnv.addObject("b", "string");
		mnv.addObject("Integer");
		
		
		//setViewName으로 다음으로 포워드 할 페이지까지 선택할 수 있는 객체
		mnv.setViewName("/hello/mnv");
		
		return mnv;
	}
	
	@PostMapping("/join")
	public String joinProcess(Member mem) {

		if(mem.nullExist()) {
			log.error("회원정보에 빈칸이있습니다");
			return "redirect:/";
		}
	
		System.out.println(mem);
		
		application.getRealPath("/data/user");
		
		File new_member_file = new File(application.getRealPath("/data/user") + mem.getId() + ".txt");
		
		if(new_member_file.exists()) {
			log.error("이미가입된 아이디입니다");
			return "redirect:/";
		}
		
		try(
			FileOutputStream fout = new FileOutputStream(new_member_file);
			ObjectOutputStream obj_out = new ObjectOutputStream(fout);
		){
			//나중에 다시 데이터를 꺼내쓰기 편하기 위해 일부러 object형태로 저장
			obj_out.writeObject(mem);
			log.info("파일을 성공적으로 씀");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
}














