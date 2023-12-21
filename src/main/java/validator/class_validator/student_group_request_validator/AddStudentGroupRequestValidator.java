package validator.class_validator.student_group_request_validator;

import request.student_group_request.AddStudentGroupRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentGroupRequestValidator implements IClassValidator<AddStudentGroupRequest> {
    private final NameValidator nameValidator;

    public AddStudentGroupRequestValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddStudentGroupRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getName(), maxLen, list, "Name");
        return list;
    }
}
