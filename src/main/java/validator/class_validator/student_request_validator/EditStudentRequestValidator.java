package validator.class_validator.student_request_validator;

import request.student_request.EditStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator implements IClassValidator<EditStudentRequest> {
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditStudentRequestValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditStudentRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        if (!nameValidator.validate(request.getLastName(), maxLen))
            list.add("LastName should be not null and less than " + maxLen + " symbols");
        if (!nameValidator.validate(request.getFirstName(), maxLen))
            list.add("FirstName should be not null and less than " + maxLen + " symbols");
        if (!nameValidator.validate(request.getMiddleName(), maxLen))
            list.add("MiddleName should be not null and less than " + maxLen + " symbols");
        if (!idValidator.validate(request.getGroupId())) list.add("GroupId should be >= 0");
        return list;
    }
}
