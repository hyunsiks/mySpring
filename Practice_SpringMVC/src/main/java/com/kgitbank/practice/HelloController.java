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
@RequestMapping("/hello") //hello�ؿ� �ִ� ������ �� �������� �����ּ���(�������� �̳༮������ �������� ã�ƿ��� ��)
public class HelloController {
	
	@Autowired
	ServletContext application;
	
	//requestMapping�� �����ܰ���ϴ¹�
	@RequestMapping(value={"/minsu", "/�μ�"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String minsu() {
		log.info("minsu controller�� ����");
		
		return "/hello/minsu";
	}
	
	//���� �Ķ���� �޴� ���
//	@GetMapping("/chulsu")
//	public void getChulsu(HttpServletRequest request) {
//		log.info("get chulsu controller�� ����");
//		log.info("name : " + request.getParameter("name"));
//	}
	//������ �Ķ���� �޴¹��(1)
//	@GetMapping("/chulsu")
//	public void getChulsu(String name, int age) {
//		log.info("get chulsu controller�� ����");
//		log.info("name : " + name);
//		log.info("age : " + age);
//	}
	//������ �Ķ���� �޴¹��(2)
	@GetMapping("/chulsu")
	public void getChulsu(Human human, @RequestParam("number") int myNumber, @RequestParam("taste") ArrayList<String> taste) {
		log.info("get chulsu controller�� ����");
		log.info("name : " + human.getName());
		log.info("age : " + human.getAge());
		log.info("myNumber : " + myNumber);
		log.info("taste : " + taste);
	}
	
	//üũ�ڽ�ó�� ������ ���ö��� ArrayList �� ������ �ȴ�
	//�� ��, @RequestParam("")�� ����ؾ� �Ѵ�
	
	
	@PostMapping("/chulsu")
	public void postChulsu() {
		log.info("post chulsu controller�� ����");
	}
	
	@GetMapping("/choosinsu")
	public String choo(Model model, @ModelAttribute("age") int age,@ModelAttribute("name") String name) {
		
		model.addAttribute("attr1", "ABC");
		model.addAttribute("ABCDEFG");
		
		//���� �̷��� �ؾߵ�
//		model.addAttribute("age", age);
//		model.addAttribute("name", name);
		
		//�׷���, @ModelAttribute�� �̿��ϸ�
		//�Ķ���Ϳ� �Ƿ��� ���� �Ű������� ������ �ְ�, �𵨿��� �ڵ����� �Ƿ��ִ�.
		System.out.println("age : " + age);
		System.out.println("name : " + name);
		
		return "/hello/attrTest"; //prefix�� subfix�� �յڷ� �پ����� �ּҰ� �����Ե�
	}
	
	//���� ���� ���� �״�� �н��� ���� �׳� �̷��Ը� �θ� ��
	//void�� �θ� class�� ������ /hello �� �޼��忡 ������ /park�� ������ /hello/park �� �̵���
	@GetMapping("/park")
	public void park(Human human) {}
	
	@GetMapping("/kim")
	public String kim() {
		//�տ� redirect:�� ���̸� �並 ã�� �ʰ� �����̷�Ʈ�� �����Ѵ�
		//!!!! ��Ʈ����Ʈ�� ������ �������� redirect: �� �ʿ��ϴٴ� ��
		return "redirect:/hello/park?name=kimC&age=32";
	}
	
	@RequestMapping("/model1")
	public ModelAndView modelAndView() {
	
		ModelAndView mnv = new ModelAndView();
		
		//addObject�� ��Ʈ����Ʈ �ư�
		mnv.addObject("a", 10);
		mnv.addObject("b", "string");
		mnv.addObject("Integer");
		
		
		//setViewName���� �������� ������ �� ���������� ������ �� �ִ� ��ü
		mnv.setViewName("/hello/mnv");
		
		return mnv;
	}
	
	@PostMapping("/join")
	public String joinProcess(Member mem) {

		if(mem.nullExist()) {
			log.error("ȸ�������� ��ĭ���ֽ��ϴ�");
			return "redirect:/";
		}
	
		System.out.println(mem);
		
		application.getRealPath("/data/user");
		
		File new_member_file = new File(application.getRealPath("/data/user") + mem.getId() + ".txt");
		
		if(new_member_file.exists()) {
			log.error("�̹̰��Ե� ���̵��Դϴ�");
			return "redirect:/";
		}
		
		try(
			FileOutputStream fout = new FileOutputStream(new_member_file);
			ObjectOutputStream obj_out = new ObjectOutputStream(fout);
		){
			//���߿� �ٽ� �����͸� �������� ���ϱ� ���� �Ϻη� object���·� ����
			obj_out.writeObject(mem);
			log.info("������ ���������� ��");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
}














