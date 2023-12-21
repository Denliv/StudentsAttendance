package validator.class_validator.teacher_request_validator;

import request.teacher_request.AddTeacherRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddTeacherRequestValidator implements IClassValidator<AddTeacherRequest> {
    private final NameValidator nameValidator;

    public AddTeacherRequestValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddTeacherRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getLastName(), maxLen, list, "LastName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "FirstName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getMiddleName(), maxLen, list, "MiddleName");
        return list;
    }
}
