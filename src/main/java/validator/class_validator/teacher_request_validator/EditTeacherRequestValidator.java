package validator.class_validator.teacher_request_validator;

import request.teacher_request.EditTeacherRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditTeacherRequestValidator implements IClassValidator<EditTeacherRequest> {
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditTeacherRequestValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditTeacherRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getLastName(), maxLen, list, "LastName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "FirstName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getMiddleName(), maxLen, list, "MiddleName");
        return list;
    }
}
