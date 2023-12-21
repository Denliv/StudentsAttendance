package validator.class_validator.student_request_validator;

import request.student_request.AddStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;
import validator.simple_validator.StatusValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator implements IClassValidator<AddStudentRequest> {
    private final StatusValidator statusValidator;
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public AddStudentRequestValidator() {
        this(new StatusValidator(), new NameValidator(), new IdValidator());
    }

    public AddStudentRequestValidator(StatusValidator statusValidator, NameValidator nameValidator, IdValidator idValidator) {
        this.statusValidator = statusValidator;
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(AddStudentRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        statusValidator.isNotNull(request.getStatus(), list, "Status");
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getLastName(), maxLen, list, "LastName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "FirstName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getMiddleName(), maxLen, list, "MiddleName");
        idValidator.isPositive(request.getGroupId(), list, "GroupId");
        return list;
    }
}
