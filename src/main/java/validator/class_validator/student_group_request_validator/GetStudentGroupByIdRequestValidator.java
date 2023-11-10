package validator.class_validator.student_group_request_validator;

import request.student_group_request.GetStudentGroupByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupByIdRequestValidator implements IClassValidator<GetStudentGroupByIdRequest> {
    private final IdValidator idValidator;

    public GetStudentGroupByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentGroupByIdRequest request) {
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
