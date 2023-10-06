package Validator.ClassValidator.SubjectRequestValidator;

import Request.SubjectRequest.AddSubjectRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddSubjectRequestValidator implements IClassValidator<AddSubjectRequest> {
    @Override
    public List<String> validate(AddSubjectRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!NameValidator.validate(request.getName(), maxLen))
            list.add("Name should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
