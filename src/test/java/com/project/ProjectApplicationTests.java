package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@SpringBootTest  //spring boot를 기동시킨다 
class ProjectApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Test
//    public void anyTest() {
//        Flux.just(3, 5, 7, 9, 11, 15, 17)
//                .any(e -> e % 2 == 0)
//                .subscribe(e -> logger.debug(String.valueOf(e)));
//    }
	
//	public enum CalcType{
//		//열거형 정의
//		CALC_A(value -> value),
//		CALC_B(value -> value * 10),
//		CALC_C(value -> value * 3),
//		CALC_ETC(value -> 0);
//		
//		//enum에 정의된 function
//		private Function<Integer, Integer> expression;
//		
//		//생성자
//		CalcType(Function<Integer, Integer> expression) {
//			this.expression = expression;
//		}
//		
//		//계산 적용 메소드
//		public int calculate(int value) {
//			return expression.apply(value);
//		}
//	}
//	
//	@Test
//	void enum_테스트2() {
//		//given - 준비
//		CalcType type = CalcType.CALC_C;
//		
//		//when - 실행
//		int result = type.calculate(500);
//		
//		//then - 검증
//		assertEquals(result, 1500);
//	}
//	
//	@Getter
//	public enum Status {
//		//열거형 정의
//		Y(1, true), //생성자 호출
//		N(0, false); //생성자 호출 ()가 있으면 무조건 생성자를 호출해야한다
//		
//		//enum 항목에 정의된 필드
//		private int value1;
//		private boolean value2;
//		
//		//생성자: 필드에 값을 세팅하는 역할
//		Status(int value1, boolean value2) {
//			this.value1 = value1;
//			this.value2 = value2;
//		}
//		
//	}
//	
//	//@Test
//	void enum_테스트1() {
//		//given - 준비(테스트의 단계)
//		Status status = Status.Y;
//		
//		//when - 실행
//		int value1 = status.getValue1();
//		boolean value2 = status.isValue2();
//				
//		//then - 검증
//		assertEquals(status, Status.Y);
//		assertEquals(value1, 1);
//		assertEquals(value2, true);
//	}
//	
//	@Test //비어있는지 체크 
//	void 검사_테스트() {
//		//String str = null;
//		String str = "";
//		if (ObjectUtils.isEmpty(str)) { //null or ""
//			logger.info("####str은 null또는 비어있다.####");
//		}
//		
//		//List<Integer> list = null;
//		List<Integer> list = new ArrayList<>();
//		if (ObjectUtils.isEmpty(list)) { //null or []
//			logger.info("$$$ list는 null이거나 비어있다");
//		}
//	}
//	
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void 더하기테스트() {
//		logger.debug("###### 더하기 테스트 수행 #####");
//		int a = 10;
//		int b = 20;
//		assertEquals(30, a + b);
//	}
//	
//	@Autowired
//	UserBO userBO;
//	
//	@Transactional //rollback시켜주는 어노테이션 - 테스트 해보고 다시 원래대로 되돌려준다
//	@Test
//	void 유저추가테스트() {
//		userBO.addUser("test", "aaaa", "test", "testest");
//	}
//	
	
}
