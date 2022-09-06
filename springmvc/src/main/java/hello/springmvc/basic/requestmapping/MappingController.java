package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	@RequestMapping("/hello-basic")
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}
	
	@RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
	public String mappingGetV1() {
		log.info("mappingGetV1");
		return "ok";
	}
	
	/**
	 * ������ ��� ������̼�(�ڵ庸��)
	 * @GetMapping
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping
	 * @PatchMapping
	 */
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}
	
	/**
	 * PathVariable ���
	 * �������� ������ ��������
	 * @PathVariable("userId") String userId -> @PathVariable userId
	 * /mapping/userA 
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId={}", data);
		return "ok";
	}
	
	/**
	 * PathVariable ��� ����
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
		log.info("mappingPath userId={}, orderId={}", userId, orderId);
		return "ok";
	}
	
	/**
	 * �Ķ���ͷ� �߰� ����
	 * params="mode"
	 * params="!mode"
	 * params="mode=debug"
	 * params="mode!=debug"
	 * params={"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-params", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}
	
	/**
	 * Ư�� ����� �߰� ����
	 * headers="mode"
	 * headers="!mode"
	 * headers="mode=debug"
	 * headers="mode!=debug"
	 */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}
	
	/**
	 * Content-Type ��� ��� �߰� ���� Media Type
	 * consumes="application/json"
	 * consumes="!application/json"
	 * consumes="application/*"
	 * consumes="*\/*"
	 * MediaType.APPLICATION_JSON_VALUE
	 */
	@PostMapping(value = "/mapping-consume", consumes = "application/json")
	public String mappingConsumes() {
		log.info("mappingConsumes");
		return "ok";
	}
	
	/**
	 * Accept ��� ��� Media Type
	 * produces="text/html"
	 * produces="!text/html"
	 * produces="text/*"
	 * produces="*\/*"
	 */
	@PostMapping(value = "/mapping-produce", produces = "text/html")
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
	
}