package com.greedy.datatests.common;

import org.springframework.data.domain.Page;

public class Pagenation {
	
	public static PagingButtonInfo getPagingButtonInfo(Page page) {
		
		int currentPage = page.getNumber() + 1;	/* page의 number는 인덱스 값이여서 +1을 해준다.*/
		int defaultButtonCount = 10;  /* 버튼의 숫자의 기본값, 1부터 시작하여 10까지 셋팅(1~10, 11~20) */
		int startPage;
		int endPage;
		
		startPage = (int) (Math.ceil((double) currentPage / defaultButtonCount) - 1) * defaultButtonCount + 1;
		endPage = startPage + defaultButtonCount - 1;
		
		if(page.getTotalPages() < endPage)
			endPage = page.getTotalPages();
		
		if(page.getTotalPages() == 0 && endPage == 0)
			endPage = startPage;
		
		return new PagingButtonInfo(currentPage, startPage, endPage);
	}

}
