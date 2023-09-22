package com.bytes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytes.repo.WorkRepository;
import com.bytes.utils.Work;

@Service
public class WorkServiceImp implements WorkService {
	@Autowired
	WorkRepository workRepository;

	@Override
	public void addWork(Work work) {
		workRepository.save(work);

	}

}
