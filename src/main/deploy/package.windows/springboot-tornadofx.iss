;This file will be executed next to the application bundle image
;I.e. current directory will contain folder springboot-tornadofx with application files
[Setup]
AppId={{de.dynamicfiles.projects.gradle.example}}
AppName=springboot-tornadofx
AppVersion=1.0.0
AppVerName=springboot-tornadofx 1.0
AppPublisher=Brian Kennedy
AppComments=This is a test
AppCopyright=Copyright (C) 2017
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\springboot-tornadofx
DisableStartupPrompt=Yes
DisableDirPage=Yes
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=The Company
;Optional License

;WinXP or above
MinVersion=0,5.1
OutputBaseFilename=[AppName]-1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=springboot-tornadofx\logo.ico
UninstallDisplayIcon={app}\logo.ico
UninstallDisplayName=springboot-tornadofx
WizardImageStretch=No
ArchitecturesInstallIn64BitMode=x64

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "springboot-tornadofx\springboot-tornadofx.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "springboot-tornadofx\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\springboot-tornadofx"; Filename: "{app}\springboot-tornadofx.exe"; IconFilename: "{app}\springboot-tornadofx.ico"; Check: returnTrue()
Name: "{commondesktop}\springboot-tornadofx"; Filename: "{app}\springboot-tornadofx.exe";  IconFilename: "{app}\springboot-tornadofx.ico"; Check: returnFalse()


[Run]
Filename: "{app}\springboot-tornadofx.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\springboot-tornadofx.exe"; Description: "{cm:LaunchProgram,springboot-tornadofx}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\springboot-tornadofx.exe"; Parameters: "-install -svcName ""springboot-tornadofx"" -svcDesc ""springboot-tornadofx"" -mainExe ""springboot-tornadofx.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\springboot-tornadofx.exe "; Parameters: "-uninstall -svcName springboot-tornadofx -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
  Result := True;
end;