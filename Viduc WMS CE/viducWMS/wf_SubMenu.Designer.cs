namespace viducWMS
{
    partial class wf_SubMenu
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(wf_SubMenu));
            this.btnCerrar = new System.Windows.Forms.PictureBox();
            this.btnProductos = new System.Windows.Forms.PictureBox();
            this.btnCategoria = new System.Windows.Forms.PictureBox();
            this.btnUbicacion = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.SuspendLayout();
            // 
            // btnCerrar
            // 
            this.btnCerrar.Image = ((System.Drawing.Image)(resources.GetObject("btnCerrar.Image")));
            this.btnCerrar.Location = new System.Drawing.Point(10, 136);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(218, 30);
            this.btnCerrar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Click);
            // 
            // btnProductos
            // 
            this.btnProductos.Image = ((System.Drawing.Image)(resources.GetObject("btnProductos.Image")));
            this.btnProductos.Location = new System.Drawing.Point(10, 102);
            this.btnProductos.Name = "btnProductos";
            this.btnProductos.Size = new System.Drawing.Size(218, 30);
            this.btnProductos.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnProductos.Click += new System.EventHandler(this.btnProductos_Click);
            // 
            // btnCategoria
            // 
            this.btnCategoria.Image = ((System.Drawing.Image)(resources.GetObject("btnCategoria.Image")));
            this.btnCategoria.Location = new System.Drawing.Point(11, 47);
            this.btnCategoria.Name = "btnCategoria";
            this.btnCategoria.Size = new System.Drawing.Size(218, 32);
            this.btnCategoria.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnCategoria.Click += new System.EventHandler(this.btnCategoria_Click);
            // 
            // btnUbicacion
            // 
            this.btnUbicacion.Image = ((System.Drawing.Image)(resources.GetObject("btnUbicacion.Image")));
            this.btnUbicacion.Location = new System.Drawing.Point(10, 206);
            this.btnUbicacion.Name = "btnUbicacion";
            this.btnUbicacion.Size = new System.Drawing.Size(218, 30);
            this.btnUbicacion.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnUbicacion.Visible = false;
            this.btnUbicacion.Click += new System.EventHandler(this.btnUbicacion_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(98, 3);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(130, 33);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            // 
            // wf_SubMenu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.ControlBox = false;
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnCerrar);
            this.Controls.Add(this.btnProductos);
            this.Controls.Add(this.btnCategoria);
            this.Controls.Add(this.btnUbicacion);
            this.MinimizeBox = false;
            this.Name = "wf_SubMenu";
            this.Text = "Consultas de Producto";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.wf_SolicitudInventario_KeyPress);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox btnCerrar;
        private System.Windows.Forms.PictureBox btnProductos;
        private System.Windows.Forms.PictureBox btnCategoria;
        private System.Windows.Forms.PictureBox btnUbicacion;
        private System.Windows.Forms.PictureBox pictureBox1;

    }
}