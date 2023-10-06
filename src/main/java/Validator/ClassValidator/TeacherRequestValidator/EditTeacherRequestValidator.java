package Validator.ClassValidator.TeacherRequestValidator;

import Request.TeacherRequest.EditTeacherRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;
import Validator.SimpleValidator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditTeacherRequestValidator implements IClassValidator<EditTeacherRequest> {
    @Override
    public List<String> validate(EditTeacherRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        if (!NameValidator.validate(request.getLastName(), maxLen))
            list.add("LastName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getFirstName(), maxLen))
            list.add("FirstName should be not null and less than " + maxLen + " symbols");
        if (!NameValidator.validate(request.getMiddleName(), maxLen))
            list.add("MiddleName should be not null and less than " + maxLen + " symbols");
        return list;
    }
}
