package aba.rest_vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aba.detail.DetailWithRotation;
import aba.detail.KoverPosition;
import aba.detail.KoverState;

public class KoverStateVO {
	private List<KoverStateEntryVO> coverage = new ArrayList<>();
	
	public static KoverStateVO fromKoverState(KoverState koverState) {
		final KoverStateVO result = new KoverStateVO();
		for (Map.Entry<KoverPosition, DetailWithRotation> entry : koverState.getPositionedDetails().entrySet()) {
			result.coverage.add(KoverStateEntryVO.fromKoverStateEntry(entry));
		}
		return result;		
	}
	
	public static KoverState toKoverState(KoverStateVO koverStateVO) {
		final KoverState koverState = new KoverState();
		final Map<KoverPosition, DetailWithRotation> resultMap = new HashMap<>();
		for (KoverStateEntryVO entry : koverStateVO.coverage) {
			resultMap.put(KoverPositionVO.toKoverPosition(entry.getKoverPositionVO()), 
					DetailWithRotationVO.toDetailWithRotation(entry.getDetailWithRotationVO()));
		}
		koverState.setPositionedDetails(resultMap);
		return koverState;
	}
}
