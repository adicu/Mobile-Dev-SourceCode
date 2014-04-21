//
//  CulpaNuggetViewController.m
//  CulpaNugget
//
//  Created by Don Yu on 4/16/14.
//  Copyright (c) 2014 Don Yu. All rights reserved.
//

#import "CulpaNuggetViewController.h"

@interface CulpaNuggetViewController ()

@property (nonatomic) NSMutableArray *professors;

@end

@implementation CulpaNuggetViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    // load up professors
    self.professors = [[NSMutableArray alloc] init];
    NSString *requestString = @"https://s3.amazonaws.com/culpa/professors.json";
    NSURL *url = [NSURL URLWithString:requestString];
    NSURLRequest *req = [NSURLRequest requestWithURL:url];
    
    NSURLSessionConfiguration *config =
    [NSURLSessionConfiguration defaultSessionConfiguration];
    NSURLSession *session = [NSURLSession sessionWithConfiguration:config
                                             delegate:nil
                                        delegateQueue:nil];
    NSURLSessionDataTask *dataTask =
    [session dataTaskWithRequest:req
                    completionHandler:
     ^(NSData *data, NSURLResponse *response, NSError *error) {
         NSString *json = [[NSString alloc] initWithData:data
                                                encoding:NSUTF8StringEncoding];
         NSArray *jsonArray = [NSJSONSerialization JSONObjectWithData:data options:nil error:nil];
         for (NSDictionary *profDict in jsonArray) {
             CulpaProfessor *prof = [[CulpaProfessor alloc] init];
             prof.firstName = [profDict valueForKey:@"first_name"];
             prof.lastName = [profDict valueForKey:@"last_name"];
             prof.nugget = [profDict valueForKey:@"nugget"];
             [self.professors addObject:prof];
         }
         
         NSLog(@"%@", json);
     }];
    [dataTask resume];

}

- (IBAction)checkProfessorClicked:(id)sender {
    [self.view endEditing:YES];
    NSString *searchText = [self.searchField text];
    for (CulpaProfessor *p in self.professors) {
        NSString *result = [p checkProfessorMatch:searchText];
        if (result == nil || [result isEqualToString:@"none"]) {
            self.resultLabel.text = @"No Nugget";
        } else if ([result isEqualToString:@"gold"]) {
            self.resultLabel.text = @"Gold Nugget! Take this Class!";
            break;
        } else if ([result isEqualToString:@"silver"]) {
            [self.resultLabel setText:@"Silver Nugget! Looks good to me!"];
            break;
        }
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
