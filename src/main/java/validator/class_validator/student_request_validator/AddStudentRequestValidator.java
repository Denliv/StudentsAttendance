package validator.class_validator.student_request_validator;

import request.student_request.AddStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator implements IClassValidator<AddStudentRequest> {
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public AddStudentRequestValidator() {
        this(new NameValidator(), new IdValidator());
    }

    public AddStudentRequestValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(AddStudentRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "LastName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "FirstName")
                .isNotNullOrEmptyAndLessThanMaxLen(request.getFirstName(), maxLen, list, "MiddleName");
        idValidator.isPositive(request.getGroupId(), list, "GroupId");
        return list;
    }
}
