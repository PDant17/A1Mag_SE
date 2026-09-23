package com.example.p2;

import java.util.List;

public class StringJoinerUtil {
    public String joinWithPlus(List<String> parts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) sb.append('+');
            sb.append(parts.get(i));
        }
        return sb.toString();
    }
}
