


#import "CDVDeviceState.h"
#import <Cordova/CDVPluginResult.h>

@implementation CDVDeviceState

@synthesize callbackId;

- (CDVPlugin*)initWithWebView:(UIWebView*)theWebView {
    self = [super init];
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(applicationDidBecomeActive) name:UIApplicationDidBecomeActiveNotification object:nil];
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(applicationDidEnterBackground) name:UIApplicationDidEnterBackgroundNotification object:nil];
    
    return self;
}


- (void)start : (CDVInvokedUrlCommand *)command
{
    NSLog(@"device state start");
    self.callbackId = command.callbackId;
    NSString* result = [NSString stringWithFormat:@"{state:%@}", @"start"];
    CDVPluginResult * pluginResult =[CDVPluginResult resultWithStatus : CDVCommandStatus_OK messageAsString : result];
    [pluginResult setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult : pluginResult callbackId : self.callbackId];
}

- (void) applicationDidBecomeActive {
    NSLog(@"trigger applicationDidBecomeActive.");
    
    NSString* result = [NSString stringWithFormat:@"{state:%@}", @"resume"];
    CDVPluginResult * pluginResult =[CDVPluginResult resultWithStatus : CDVCommandStatus_OK messageAsString : result];
    [pluginResult setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult : pluginResult callbackId : self.callbackId];
}

- (void) applicationDidEnterBackground {
    NSLog(@"trigger applicationDidEnterBackground.");
    NSString* result = [NSString stringWithFormat:@"{state:%@}", @"pause"];
    CDVPluginResult * pluginResult =[CDVPluginResult resultWithStatus : CDVCommandStatus_OK messageAsString : result];
    [pluginResult setKeepCallbackAsBool:YES];
    [self.commandDelegate sendPluginResult : pluginResult callbackId : self.callbackId];
}

@end
