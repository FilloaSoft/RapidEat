package com.filloasoft.rapideat.restexample;

import java.util.List;

public interface ExampleService {

	List<Example> getList();

	Example addElementToList(Example example);

}