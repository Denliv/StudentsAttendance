package Validator.ClassValidator.SubjectRequestValidator;

import Request.SubjectRequest.GetSubjectByIdRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectByIdRequestValidator implements IClassValidator<GetSubjectByIdRequest> {
    @Override
    public List<String> validate(GetSubjectByIdRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
