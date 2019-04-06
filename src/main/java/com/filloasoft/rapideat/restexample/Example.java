package com.filloasoft.rapideat.restexample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Example {
	
	@Id
    private Long id;
    private String content;
    
    public Example() {
	}
    
    public Example(String content) {
    	this.content = content;
    }

    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
    	this.content = content;
    }
}
