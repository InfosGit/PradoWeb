namespace viducWMS
{
    partial class MenuTrasladoInterno
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MenuTrasladoInterno));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnCerrar = new System.Windows.Forms.PictureBox();
            this.btnTransalado = new System.Windows.Forms.PictureBox();
            this.btnRecepcion = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(102, 9);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(130, 33);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            // 
            // btnCerrar
            // 
            this.btnCerrar.Image = ((System.Drawing.Image)(resources.GetObject("btnCerrar.Image")));
            this.btnCerrar.Location = new System.Drawing.Point(13, 184);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(218, 30);
            this.btnCerrar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnCerrar.Tag = "Salir";
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Click);
            // 
            // btnTransalado
            // 
            this.btnTransalado.Image = ((System.Drawing.Image)(resources.GetObject("btnTransalado.Image")));
            this.btnTransalado.Location = new System.Drawing.Point(13, 147);
            this.btnTransalado.Name = "btnTransalado";
            this.btnTransalado.Size = new System.Drawing.Size(218, 30);
            this.btnTransalado.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnTransalado.Tag = "Transalado Producto";
            this.btnTransalado.Click += new System.EventHandler(this.btnTransalado_Click);
            // 
            // btnRecepcion
            // 
            this.btnRecepcion.Image = ((System.Drawing.Image)(resources.GetObject("btnRecepcion.Image")));
            this.btnRecepcion.Location = new System.Drawing.Point(13, 110);
            this.btnRecepcion.Name = "btnRecepcion";
            this.btnRecepcion.Size = new System.Drawing.Size(218, 30);
            this.btnRecepcion.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnRecepcion.Tag = "Recepción Producto";
            this.btnRecepcion.Click += new System.EventHandler(this.btnRecepcion_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(14, 63);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(218, 32);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox2.Tag = "Recepción Producto";
            // 
            // MenuTrasladoInterno
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnCerrar);
            this.Controls.Add(this.btnTransalado);
            this.Controls.Add(this.btnRecepcion);
            this.Name = "MenuTrasladoInterno";
            this.Text = "MenuTrasladoInterno";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox btnCerrar;
        private System.Windows.Forms.PictureBox btnTransalado;
        private System.Windows.Forms.PictureBox btnRecepcion;
        private System.Windows.Forms.PictureBox pictureBox2;
    }
}