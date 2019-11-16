package com.example.pyramid.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pyramid")
public class PyramidController {

	Logger logger = LoggerFactory.getLogger(PyramidController.class);

	@RequestMapping(value = "/{word}", method = RequestMethod.GET)
	public ResponseEntity<String> getProductByCategoryAvailability(@PathVariable("word") String word) {

		if (null != word) {
			HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			char[] strArray = word.toCharArray();

			for (char c : strArray) {
				if (charCountMap.containsKey(c)) {
					charCountMap.put(c, charCountMap.get(c) + 1);
				} else {
					charCountMap.put(c, 1);
				}
			}

			List<Integer> pyramidListValues = new ArrayList(charCountMap.values());
			Collections.sort(pyramidListValues);

			Set<Integer> pyramidSetValues = new HashSet<Integer>(pyramidListValues);
			logger.info("pyramidSetValues size : " + pyramidSetValues.size());
			int uniqeCount = pyramidSetValues.size();

			int totalCount = pyramidListValues.size();
			logger.info("totalCount : " + totalCount);

			int lastElement = pyramidListValues.get(totalCount - 1);
			logger.info("lastElement : " + lastElement);

			if (totalCount == lastElement && uniqeCount == totalCount) {
				return ResponseEntity.ok("true");
			} else {
				return ResponseEntity.ok("false");
			}

		} else {
			return new ResponseEntity("Input is not valid", HttpStatus.BAD_REQUEST);
		}
	}

}
