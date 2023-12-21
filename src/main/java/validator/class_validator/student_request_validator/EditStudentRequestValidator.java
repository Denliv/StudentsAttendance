package validator.class_validator.student_request_validator;

import request.student_request.EditStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;
import validator.simple_validator.StatusValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator implements IClassValidator<EditStudentRequest> {
    private final StatusValidator statusValidator;
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditStudentRequestValidator(StatusValidator statusValidator, NameValidator nameValidator, IdValidator idValidator) {
        this.statusValidator = statusValidator;
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditStudentRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        statusValidator.isNotNull(request.getStatus(), list, "Status");
        idValidator.isPositive(request.getId(), list, "Id")
                .isPositive(request.getGroupId(), list, "GroupId");
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getLastName(), maxLen, list, "LastName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "FirstName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getMiddleName(), maxLen, list, "MiddleName");
        return list;
    }
}
