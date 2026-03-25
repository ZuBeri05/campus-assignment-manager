package com.zuberi.cam.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SimilarityService {
    // simple Jaccard similarity on tokens
    public double similarity(String a, String b) {
        if (a == null || b == null) return 0.0;
        Set<String> sa = new HashSet<>(Set.of(a.split("\\s+")));
        Set<String> sb = new HashSet<>(Set.of(b.split("\\s+")));
        if (sa.isEmpty() || sb.isEmpty()) return 0.0;
        Set<String> inter = new HashSet<>(sa);
        inter.retainAll(sb);
        Set<String> union = new HashSet<>(sa);
        union.addAll(sb);
        return (double) inter.size() / (double) union.size();
    }
}
