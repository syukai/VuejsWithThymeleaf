package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PostController {
	
	public static class IdAndColor{
		public Integer id;
		public String color;
		
		public IdAndColor(){
			
		}
		public IdAndColor(Integer id, String color){
			this.id=id;
			this.color=color;
		}
	}

	@PostMapping("post")
	public String post(@Valid @RequestBody List<IdAndColor> body
			,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "";
		}
		body.forEach(r->{System.out.println("id:"+r.id + ", color:"+r.color);});
		
		
		return "";
	}
	
	@GetMapping("get")
	public List<IdAndColor>  get(){
		List<IdAndColor> list = new ArrayList<IdAndColor>();
		list.add(new IdAndColor(0,"blue"));
		list.add(new IdAndColor(1,"navy"));
		list.add(new IdAndColor(2,"yellow"));
		
		return list;
	}
}
