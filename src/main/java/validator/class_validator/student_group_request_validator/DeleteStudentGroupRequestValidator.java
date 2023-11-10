package validator.class_validator.student_group_request_validator;

import request.student_group_request.DeleteStudentGroupRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentGroupRequestValidator implements IClassValidator<DeleteStudentGroupRequest> {
    private final IdValidator idValidator;

    public DeleteStudentGroupRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteStudentGroupRequest request) {
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
