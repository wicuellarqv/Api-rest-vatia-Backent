package com.vatia.apirest.utils;

import org.springframework.data.domain.PageRequest;

public class CheckPageable {
	public static PageRequest size(Integer page, Integer size) {
		return size != null
				? size > 0 
					? PageRequest.of(page, size)
					: PageRequest.of(page, 10)
				: PageRequest.of(page, 10);
	}
}
