package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("getdata")
public class restGetData {
	
	
	private static class Response{
		public Integer id;
		public String value;
		public Response(int id, String value){
			this.id = id;
			this.value=value;
		}
	}

	@CrossOrigin
	@GetMapping("{key}")
	public List<Response> getdata(@PathVariable("key") Integer key){
		List<Response> retmap = new ArrayList<Response>();
		
		for(int i=0;i<3;i++){
			retmap.add(new Response(i+key, "value-"+Integer.valueOf(i+key).toString()));
		}
		
		
		return retmap;
	}
	
	
}
