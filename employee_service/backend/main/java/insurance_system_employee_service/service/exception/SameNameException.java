package insurance_system_employee_service.service.exception;

public class SameNameException extends Exception{
    public SameNameException(String inputName , String originId) {
        super(inputName+"과 기존 DB의 [ID : " +originId+"]의 이름이 같습니다.");
    }
}
