package com.wut.learn.base.completableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTongBu {
    public static void main(String[] args) {
        // 创建一个列表来保存CompletableFuture
        List<CompletableFuture<Void>> fileProcessingTasks = new ArrayList<>();

        // 模拟创建10个文件处理任务
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                // 模拟文件处理操作
                System.out.println("Processing file " + finalI);
                // 模拟成功处理
            });

            fileProcessingTasks.add(task);
        }

        // 使用allOf等待所有任务完成
        CompletableFuture<Void> allOf = CompletableFuture.allOf(fileProcessingTasks.toArray(new CompletableFuture[0]));

        try {
            // 等待所有任务完成
            allOf.get();

            // 所有文件处理成功
            System.out.println("All files processed successfully!");
        } catch (InterruptedException | ExecutionException e) {
            // 处理异常情况
            System.err.println("An error occurred while processing files: " + e.getMessage());
        }
    }
}
