package com.filloasoft.rapideat.restexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
	
	@Autowired
	private ExampleRepository exampleRepository;
	
	/* (non-Javadoc)
	 * @see com.filloasoft.rapideat.restexample.ExampleService#getList()
	 */
	@Override
	public List<Example> getList(){
		return this.exampleRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.filloasoft.rapideat.restexample.ExampleService#addElementToList(com.filloasoft.rapideat.restexample.Example)
	 */
	@Override
	public Example addElementToList(Example example) {
		return this.exampleRepository.save(example);
	}
}

