package com.greedy.datatests.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.datatests.common.Pagenation;
import com.greedy.datatests.common.PagingButtonInfo;
import com.greedy.datatests.employee.dto.DepartmentDTO;
import com.greedy.datatests.employee.dto.EmployeeDTO;
import com.greedy.datatests.employee.dto.JobDTO;
import com.greedy.datatests.employee.dto.SalLevelDTO;
import com.greedy.datatests.employee.service.EmpService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/employee")
public class EmpController {
	
	private final EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	/* 전체 사원 조회*/
	@GetMapping("/list")
	public String findEmpList(Model model) {
		
		List<EmployeeDTO> empList = empService.findAllEmpList();
		
		model.addAttribute("empList", empList);
		
		return "employee/list";
	}
	
	/* 전체 사원 조회 (페이징 처리) */
	@GetMapping("/listpaging")
	public String fingEmpListPaging(@PageableDefault Pageable pageable, Model model) {		
		
	
		Page<EmployeeDTO> empList = empService.findAllEmpListPaging(pageable);
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(empList);
		
		model.addAttribute("empList", empList);
		model.addAttribute("paging", paging);
		
		return "employee/listpaging";
	}
	
	
	/* 사원 등록 페이징 */
	@GetMapping("/regist")
	public void registtPage() {}
	
	/* 부서명 option 처리 비동기 통신*/
	@GetMapping(value="/dept", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<DepartmentDTO> findDeptList(){
		log.info("[Controller] empService.findAllDept() : {} ", empService.findAllDept());
		return empService.findAllDept();
	}
	
	/* 직급명 option 처리 비동기 통신*/
	@GetMapping(value="/job", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<JobDTO> findJobList(){
		log.info("[Controller] empService.findAlljob() : {} ", empService.findAlljob());
		return empService.findAlljob();
	}
	
	/* 급여등급 option 처리 비동기 통신*/
	@GetMapping(value="/sal", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalLevelDTO> findSalLevelList(){
		log.info("[Controller] empService.findAllSalLevel() : {} ", empService.findAllSalLevel());
		return empService.findAllSalLevel();
	}
	
	/* 사원번호 중복확인 처리 비동기 통신*/
	@GetMapping(value="/empList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<EmployeeDTO> findByEmpList(){
		log.info("[Controller] empService.findAllEmpList() : {} ", empService.findAllEmpList());
		return empService.findAllEmpList();
	}
	
	
	
	/* 사원 정보 등록 */
	@PostMapping("/regist")
	public String regitstNewEmp(EmployeeDTO emp) {
		
		log.info("emp : " + emp);
		
		empService.registNewEmp(emp);
		
		return "redirect:/employee/list";
	}
	
	
	/* 사원 정보 수정 페이지*/
	@GetMapping("/modify")
	public void modifyPage() {}
	
	/* 사원리스트 출력 비동기 통신*/
	@GetMapping(value="/findByEmpId", produces="application/json; charset=UTF-8")
	@ResponseBody
	public EmployeeDTO findByEmpId(String empId){
		log.info("[Controller] empService.findByEmpId() : {} ", empService.findByEmpId(empId));
		return empService.findByEmpId(empId);
	}
	
	/* 사원 정보 수정 */
	@PostMapping("/modify")
	public String modifyEmp(EmployeeDTO emp, RedirectAttributes rttr) {
		
		EmployeeDTO beforeModifyEmp = empService.findByEmpId(emp.getEmpId());
		
		empService.modifyEmp(emp);
		
		EmployeeDTO afterModifyEmp = empService.findByEmpId(emp.getEmpId());
		
		Map<String, EmployeeDTO> empMap = new HashMap<>();
		empMap.put("beforeModifyEmp", beforeModifyEmp);
		empMap.put("afterModifyEmp", afterModifyEmp);
		
		rttr.addFlashAttribute("empMap", empMap);
	
		log.info("[Controller] modifyEmp emp: {}", emp);
		
		return "redirect:/employee/"+ emp.getEmpId();
	}
	
	/* 수정된 사원 정보 결과 페이지 */
	@GetMapping("/{empId}")
	public String modifyResult(@PathVariable String empId, Model model) {
		log.info("[Controller] modifyResult empId: {}", empId);
		EmployeeDTO emp = empService.findByEmpId(empId);
		
		model.addAttribute("emp", emp);
		
		return "employee/modifyResult";
	}
	
	
	/* 사원 정보 삭제 페이지*/
	@GetMapping("/delete")
	public void deletePage() {}
	
	
	@PostMapping("/delete")
	public String deleteEmp(String empId, RedirectAttributes rttr) {
		
		EmployeeDTO emp = empService.findByEmpId(empId);
		
		String message = emp.getEmpName()+ "이(가) 삭제 되었습니다.";
		rttr.addFlashAttribute("message", message);
		
		empService.deleteEmp(empId);
		
		return "redirect:/employee/list";
	}
	
}
