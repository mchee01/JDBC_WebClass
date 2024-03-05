package day7.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode			//필수. vo (불변객체) 로 정의하기 - Map의 key 객체로 사용하기 위함.
public class RequestMap {
	private String url;		//servlet Path 
	private String method;	//GET,POST
}
