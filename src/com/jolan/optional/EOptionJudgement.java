package com.jolan.optional;

import com.jolan.stream.aExample.Author;

import java.util.Optional;

/**
 * isPresent:是否存在
 */
public class EOptionJudgement {
    public static void main(String[] args) {
        Optional<Author> optionalAuthor = BOptionalCreate.getOptionalAuthor();
        if (optionalAuthor.isPresent()) {
            System.out.println(optionalAuthor.get().getName());
        }
    }
}
