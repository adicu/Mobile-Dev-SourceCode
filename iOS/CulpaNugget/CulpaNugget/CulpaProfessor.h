//
//  CulpaProfessor.h
//  CulpaNugget
//
//  Created by Don Yu on 4/16/14.
//  Copyright (c) 2014 Don Yu. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CulpaProfessor : NSObject

@property NSString *nugget;
@property NSString *firstName;
@property NSString *lastName;

-(NSString *) checkProfessorMatch:(NSString *)matchQuery;

@end
