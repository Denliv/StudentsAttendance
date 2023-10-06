package Validator.ClassValidator.TeacherRequestValidator;

import Request.TeacherRequest.AddTeacherRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class AddTeacherRequestValidator implements IClassValidator<AddTeacherRequest> {
    @Override
    public List<String> validate(AddTeacherRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!NameValidator.validate(request.getLastName(), maxLen))
            list.add("LastName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getFirstName(), maxLen))
            list.add("FirstName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getMiddleName(), maxLen))
            list.add("MiddleName should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
