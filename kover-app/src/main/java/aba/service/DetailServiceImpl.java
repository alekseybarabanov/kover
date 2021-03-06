package aba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aba.detail.Detail;
import aba.repository.DetailRepository;
import aba.persistence_vo.DetailVO;

@Service
public class DetailServiceImpl implements DetailService {
	
	@Autowired
	private DetailRepository repository;

	@Override
	public List<Detail> getAll() {
		final List<DetailVO> detailVOs = repository.findAll();
		final List<Detail> details = new ArrayList<Detail>();
		for (DetailVO detailVO: detailVOs) {
			details.add(DetailVO.toDetail(detailVO));
		}
		return details;
	}

	@Override
	public List<DetailVO> getAllVO() {
		return repository.findAll();
	}

	@Override
	public void create(Detail detail) {
		DetailVO detailVO = DetailVO.fromDetail(detail);
		repository.save(detailVO);
	}
	
	

	
}
