//
//  CDVDeviceState.h
//  理财街
//
//  Created by maning on 15/10/24.
//
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

@interface CDVDeviceState : CDVPlugin {

}
@property (nonatomic, strong) NSString* callbackId;

- (void)start:(CDVInvokedUrlCommand*)command;

@end
