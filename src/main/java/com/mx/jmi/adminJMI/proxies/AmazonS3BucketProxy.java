package com.mx.jmi.adminJMI.proxies;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class AmazonS3BucketProxy {
	
	private String bucketName;
	private String accessKey;
	private String secretKey;
	private AWSCredentials credentials;
	private AmazonS3 s3client;
	
	public AmazonS3BucketProxy(String bucketName, String accessKey, String secretKey) {
		this.bucketName = bucketName;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		
		this.credentials = new BasicAWSCredentials(
				accessKey, 
				secretKey
				);
		
		this.s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_2)
				  .build();
	}
	
	
	
	public void amazonBucketList() {
		
		List<Bucket> buckets = s3client.listBuckets();
		for(Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		}
	}
	
	public String uploadObject(String imagePath) {

		File file = new File(imagePath);
        String objectKey = file.getName();
        PutObjectResult result = s3client.putObject(new PutObjectRequest(bucketName, objectKey, file).withCannedAcl(CannedAccessControlList.PublicRead));
        String imageURL = String.valueOf(s3client.getUrl(
        		bucketName,
                file.getName()));
        return imageURL;
	}
	

}
