//
//  CulpaProfessor.m
//  CulpaNugget
//
//  Created by Don Yu on 4/16/14.
//  Copyright (c) 2014 Don Yu. All rights reserved.
//

#import "CulpaProfessor.h"

@implementation CulpaProfessor

-(NSString *) checkProfessorMatch:(NSString *)matchQuery
{
    if ([matchQuery rangeOfString:self.lastName].location != NSNotFound
        || [matchQuery rangeOfString:self.firstName].location != NSNotFound) {
        return self.nugget;
    } else {
        return nil;
    }
}

@end
