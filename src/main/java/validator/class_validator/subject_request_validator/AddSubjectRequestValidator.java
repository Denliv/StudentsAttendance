package validator.class_validator.subject_request_validator;

import request.subject_request.AddSubjectRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddSubjectRequestValidator implements IClassValidator<AddSubjectRequest> {
    private final NameValidator nameValidator;

    public AddSubjectRequestValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddSubjectRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!nameValidator.validate(request.getName(), maxLen))
            list.add("Name should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
