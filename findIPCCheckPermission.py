from code_analysis import code_analysis

ca=code_analysis()

ca.findCodeInSmali(".","checkCallingOrSelfPermission|checkCallingOrSelfUriPermission|checkCallingPermission|checkCallingUriPermission|enforceCallingOrSelfPermission|enforceCallingOrSelfUriPermission|enforceCallingPermission|enforceCallingUriPermission","checkIPCPermissionAPK")

