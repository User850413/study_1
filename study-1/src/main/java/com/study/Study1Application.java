package com.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Study1Application {
	public static void main(String[] args) {
		SpringApplication.run(Study1Application.class, args);
		log.debug("study app started");
		
		log.info("===================================");
		log.info("첫 번째 문제 : 25 이상인 숫자 추출 후 각각 2배로 하고, 새로운 리스트로 수집 후 출력");
		List<Integer> numbers = Arrays.asList(10,20,30,40,50);
		List<Integer> newNumbers = numbers.stream()
				.filter(n -> n>=25)
				.map(n -> n*2)
				.collect(Collectors.toList());
		log.info(newNumbers.toString());
		log.info("===================================");
		
		log.info("두 번째 문제 : 길이가 5 이상인 단어만 필터링 후 대문자 변환, 알파벳 순으로 정렬 후 출력");
		List<String> words = Arrays.asList("apple", "banana", "kiwi","orange");
		List<String> newWords = words.stream()
				.filter(w -> w.length() >= 5)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		log.info(newWords.toString());
		log.info("===================================");

		log.info("세 번째 문제 : 나이가 20 이상인 사람의 이름만 리스트로 추출");
		Map<String, Integer> people = new HashMap<>();
		people.put("첫째", 35);
		people.put("둘째", 25);
		people.put("셋째", 15);
		people.put("넷째", 5);
		
		List<String> names = people.entrySet().stream()
				.filter(p -> p.getValue() >= 20)
				.map(p -> p.getKey())
				.collect(Collectors.toList());
		log.info(names.toString());
		log.info("===================================");
		
	}
}
