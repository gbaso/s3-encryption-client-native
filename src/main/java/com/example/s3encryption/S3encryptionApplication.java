package com.example.s3encryption;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.encryption.s3.S3EncryptionClient;

@SpringBootApplication
public class S3encryptionApplication {

	private static final String KMS_KEY_ID = "some kms id";

	public static void main(String[] args) {
		SpringApplication.run(S3encryptionApplication.class, args);
	}

	@Bean
	ApplicationRunner runner() {
		return args -> {
			try (var client = withS3Client()) {
				// do stuff
				System.out.println("using s3 encryption client");
			}
		};
	}

	private S3Client withS3Client() {
		return S3EncryptionClient.builder()
				.wrappedClient(S3Client.builder()
						.region(Region.EU_CENTRAL_1)
						.credentialsProvider(DefaultCredentialsProvider.create())
						.build())
				.kmsKeyId(KMS_KEY_ID)
				.build();
	}

}
