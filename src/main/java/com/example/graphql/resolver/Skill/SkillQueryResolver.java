package com.example.graphql.resolver.Skill;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Skill;
import com.example.graphql.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkillQueryResolver implements GraphQLQueryResolver {

    private final SkillRepository skillRepository;

    public Iterable<Skill> skills(){
        return skillRepository.findAll();
    }

    public Skill skill(int id){
        return skillRepository.findById(id).orElse(null);
    }
}
