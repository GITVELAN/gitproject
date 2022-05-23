- hosts: all
  remote_user: ec2-user
  become: yes
  tasks:
  - name: Install the latest version of Apache
    yum:
      name: httpd
      state: latest
  - name: Start service httpd, if not stop
    service:
      name: httpd
      state: started
  - name: Copy file with owner 
    copy:
      src: /home/ec2-user/index.html
      dest: /var/www/html/index.html
      mode: '777'
