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
        if (!nameValidator.validate(request.getLastName(), maxLen))
            list.add("LastName should be not null and less than " + maxLen + " symbols");
        if (!nameValidator.validate(request.getFirstName(), maxLen))
            list.add("FirstName should be not null and less than " + maxLen + " symbols");
        if (!nameValidator.validate(request.getMiddleName(), maxLen))
            list.add("MiddleName should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
